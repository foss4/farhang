
package nejati.me.omdbapi.webServices.farhangModel.dictionary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DictionaryResult {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("meaning")
    @Expose
    private String meaning;
    @SerializedName("dictionary")
    @Expose
    private String dictionary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getDictionary() {
        return dictionary;
    }

    public void setDictionary(String dictionary) {
        this.dictionary = dictionary;
    }

}
