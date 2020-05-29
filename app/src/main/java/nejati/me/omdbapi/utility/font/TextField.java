package nejati.me.omdbapi.utility.font;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import nejati.me.omdbapi.R;


/**
 * Created by RezaNejati on 7/2/2018.
 */


public class TextField extends TextView {

    public TextField(final Context context, final AttributeSet attrs) {
        super(context, attrs, R.attr.fontPathCalligraphyConfig);
    }

}
