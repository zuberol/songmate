package pl.jzuber.songmate.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import pl.jzuber.songmate.exceptions.BuilderMethodNotFound;
import pl.jzuber.songmate.exceptions.ChallengeClassNotKnown;
import pl.jzuber.songmate.exceptions.JsonPropertyNotMatched;
import pl.jzuber.songmate.exceptions.NotBuilderClass;
import pl.jzuber.songmate.model.challenges.Challenge;
import pl.jzuber.songmate.model.challenges.SendMeSongChallenge;
import pl.jzuber.songmate.services.ChallengeService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class CustomChallengeDeserializer extends JsonDeserializer<Challenge> {

    ChallengeService challengeService;

    @Autowired
    public CustomChallengeDeserializer(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @Override
    public Challenge deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);

        try {
            final String challengeName = root.get("challengeName").textValue();
            String challengeFullClassName = Optional.ofNullable(challengeName)
                                                    .map(ch -> challengeService.challengeMap.get(ch))
                                                    .orElseThrow(ChallengeClassNotKnown::new);
            Class<?> theClass = Class.forName(challengeFullClassName);

            final Method[] methods = theClass.getMethods();
            final Method builderMethod = Arrays.stream(methods)
                                                .filter(method ->method.getName().matches("builder"))
                                                .findAny().
                                                orElseThrow(NotBuilderClass::new);

            var challengeBuilderObject = builderMethod.invoke(null);
            final Class<?> challengeBuilderClass = challengeBuilderObject.getClass();
            final Method[] challengeBuilderClassMethods = challengeBuilderClass.getMethods();

            final Iterator<Map.Entry<String, JsonNode>> entryIterator = root.fields();
            Outer : while(entryIterator.hasNext()){
                final Map.Entry<String, JsonNode> jsonNodeEntry = entryIterator.next();
                final String jsonNodeEntryKey = jsonNodeEntry.getKey();
                final String jsonNodeEntryValue = jsonNodeEntry.getValue().textValue();

                    Inner : for(Method m : challengeBuilderClassMethods){
                        if (m.getName().matches(jsonNodeEntryKey)) {
                            challengeBuilderObject = m.invoke(challengeBuilderObject, jsonNodeEntryValue);
                            continue Outer;
                        }
                    }
                    throw new JsonPropertyNotMatched();
            }

            //use build and return challenge object
            final Method buildMethod = Arrays.stream(challengeBuilderClassMethods)
                    .filter(method -> method.getName() == "build")
                    .filter(method -> method.getReturnType().getName() != "pl.jzuber.songmate.model.challenges.Challenge")
                    .findAny()
                    .orElseThrow(BuilderMethodNotFound::new);

            buildMethod.setAccessible(true);
            final Object buildedChallenge = buildMethod.invoke(challengeBuilderObject);
            return (Challenge) buildedChallenge;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (JsonPropertyNotMatched e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {

        }

        return new SendMeSongChallenge();
    }
}
