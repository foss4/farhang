package nejati.me.omdbapi.viewModels.mainActivity

import androidx.databinding.ObservableField
import nejati.me.omdbapi.utility.Tools

/**
 * Authors:
 * Reza Nejati <rn.nejati@gmail.com>
 * Copyright © 2020
 */
class HourlyItemViewModel(
    hourly: String
) {
    var ratingItems = ObservableField<String>()
    var weatherImage = ObservableField<Int>()

    init {
        ratingItems.set(hourly)
/*        weatherImage.set(Tools.getWeatherImage("Clear"))*/

    }

}
