package pl.jzuber.songmate.model.messages;

public class SpotifyAuthPrerequisite {
    public final String CODE;
    public final String STATE;

    public SpotifyAuthPrerequisite(String code, String state) {
        this.CODE = code;
        this.STATE = state;
    }

    public boolean isValid() {
        if(this.CODE == null || this.STATE == null) return false;
        if(this.CODE.length() != 0 && this.STATE.length() != 0) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "SpotifyAuthPrerequisite{" +
                "CODE='" + CODE + '\'' +
                ", STATE='" + STATE + '\'' +
                '}';
    }
}
