package pl.jzuber.songmate.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import pl.jzuber.songmate.exceptions.ChallengeClassNotKnown;
import pl.jzuber.songmate.exceptions.NotBuilderClass;
import pl.jzuber.songmate.model.challenges.Challenge;
import pl.jzuber.songmate.model.challenges.SendMeSongChallenge;
import pl.jzuber.songmate.services.ChallengeService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Stream;

public class CustomChallengeDeserializer extends JsonDeserializer<Challenge> {

    ChallengeService challengeService;

    @Autowired
    public CustomChallengeDeserializer(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @Override
    public Challenge deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);


        //public static pl.jzuber.songmate.model.challenges.SendMeSongChallenge$SendMeSongChallengeBuilder pl.jzuber.songmate.model.challenges.SendMeSongChallenge.builder()
        try {
            final String challengeName = node.get("challengeName").textValue();
            String challengeFullClassName = Optional.ofNullable(challengeName)
                                                    .map(ch -> challengeService.challengeMap.get(ch))
                                                    .orElseThrow(ChallengeClassNotKnown::new);
            Class<?> theClass = Class.forName(challengeFullClassName);

//            final Method[] declaredMethods = theClass.getDeclaredMethods();
//            Arrays.stream(declaredMethods).forEach(System.out::println);
//
//            final Class<?>[] declaredClasses = theClass.getDeclaredClasses();
//            Arrays.stream(declaredClasses).forEach(System.out::println);


            //System.out.println(challengeFullClassName);



            final String builderRegex = ".*" + (challengeName + ".builder()$")
                                                    .replace(".", "\\.")
                                                    .replace("(","\\(")
                                                    .replace(")","\\)");




           // final String builderRegex = challengeFullClassName + "\.builder\(\)";
            final Method[] methods = theClass.getMethods();
            //Arrays.stream(methods).forEach(System.out::println);


            final Optional<Method> builderMethod = Arrays.stream(methods).filter(method ->
                    method.getName().matches("builder")
            ).findFirst();

            var challengeBuilderObject = builderMethod.orElseThrow(NotBuilderClass::new).invoke(new SendMeSongChallenge());

            final Class<?> challengeBuilderClass = challengeBuilderObject.getClass();
            final Method[] challengeBuilderClassMethods = challengeBuilderClass.getMethods();
            Arrays.stream(challengeBuilderClassMethods).forEach(System.out::println);
//            System.out.println();
//            Arrays.stream(methods).forEach(c ->
//                    System.out.println(c.getName())
//            );

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


//        try {
//            String challengeFullClassName = Optional.ofNullable(node.get("challengeName").textValue())
//                                                    .map(ch -> challengeService.challengeMap.get(ch))
//                                                    .orElseThrow(ClassNotFoundException::new);
//            Class<?> theClass = Class.forName(challengeFullClassName);
//
//
//            var createdChallenge = theClass.getDeclaredConstructor().newInstance();
//            System.out.println("CustomDeserializer: " + List.of(createdChallenge));
//        } catch (ClassNotFoundException | NoSuchMethodException e){
//           e.printStackTrace();
//
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }



        return new SendMeSongChallenge();
    }

// class Artist
//    private Long id;
//    private String href;                // A link to the Web API endpoint providing full details of the artist.
//    private String spotify_id;          //	The Spotify ID for the artist.
//    private String name;               //  The name of the artist.
//    private String uri;                 //	string	The Spotify URI for the artist.

}
