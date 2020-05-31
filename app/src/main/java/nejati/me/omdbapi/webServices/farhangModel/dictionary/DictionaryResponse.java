
package nejati.me.omdbapi.webServices.farhangModel.dictionary;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DictionaryResponse {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("results")
    @Expose
    private List<DictionaryResult> dictionaryResults = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DictionaryResult> getDictionaryResults() {
        return dictionaryResults;
    }

    public void setDictionaryResults(List<DictionaryResult> dictionaryResults) {
        this.dictionaryResults = dictionaryResults;
    }

}
