package s20079853.mad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

//    val cards = arrayOf(
//        R.drawable.icon_high,
//        R.drawable.icon_low
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestJSONToday()
        requestJSONArrayforecast()
    }

        fun requestJSONArrayforecast() {

            var todaytemp = findViewById<TextView>(R.id.todayTemperature_TV)

            var next1day = findViewById<TextView>(R.id.next1day_TV)
            var next2day = findViewById<TextView>(R.id.next2day_TV)
            var next3day = findViewById<TextView>(R.id.next3day_TV)
            var next4day = findViewById<TextView>(R.id.next4day_TV)
            var next5day = findViewById<TextView>(R.id.next5day_TV)
            var next6day = findViewById<TextView>(R.id.next6day_TV)
            var next7day = findViewById<TextView>(R.id.next7day_TV)

            var oneweek = findViewById<TextView>(R.id.oneweek_TV)
            var twoweek = findViewById<TextView>(R.id.twoweek_TV)
            var threeweek = findViewById<TextView>(R.id.threeweek_TV)
            var fourweek = findViewById<TextView>(R.id.fourweek_TV)
            var fiveweek = findViewById<TextView>(R.id.fiveweek_TV)
            var sixweek = findViewById<TextView>(R.id.sixweek_TV)
            var sevenweek = findViewById<TextView>(R.id.sevenweek_TV)

            var next1DayTemp = findViewById<TextView>(R.id.Next1DayTemp_TV)
            var next2DayTemp = findViewById<TextView>(R.id.Next2DayTemp_TV)
            var next3DayTemp = findViewById<TextView>(R.id.Next3DayTemp_TV)
            var next4DayTemp = findViewById<TextView>(R.id.Next4DayTemp_TV)
            var next5DayTemp = findViewById<TextView>(R.id.Next5DayTemp_TV)
            var next6DayTemp = findViewById<TextView>(R.id.Next6DayTemp_TV)
            var next7DayTemp = findViewById<TextView>(R.id.Next7DayTemp_TV)

            var url = "https://data.weather.gov.hk/weatherAPI/opendata/weather.php?dataType=fnd&lang=en"
            var queue = Volley.newRequestQueue(this)
            var request = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener { response ->

                var todaytemperature = response.getJSONArray("weatherForecast").getJSONObject(0).getJSONObject("forecastMaxtemp").getString("value")
                todaytemp.text = String.format("%s%s",todaytemperature.toString(), getString(R.string.tempC))

                next1day.text = response.getJSONArray("weatherForecast").getJSONObject(1).getString("forecastDate")
                next2day.text = response.getJSONArray("weatherForecast").getJSONObject(2).getString("forecastDate")
                next3day.text = response.getJSONArray("weatherForecast").getJSONObject(3).getString("forecastDate")
                next4day.text = response.getJSONArray("weatherForecast").getJSONObject(4).getString("forecastDate")
                next5day.text = response.getJSONArray("weatherForecast").getJSONObject(5).getString("forecastDate")
                next6day.text = response.getJSONArray("weatherForecast").getJSONObject(6).getString("forecastDate")
                next7day.text = response.getJSONArray("weatherForecast").getJSONObject(7).getString("forecastDate")

                oneweek.text = response.getJSONArray("weatherForecast").getJSONObject(1).getString("week")
                twoweek.text = response.getJSONArray("weatherForecast").getJSONObject(2).getString("week")
                threeweek.text = response.getJSONArray("weatherForecast").getJSONObject(3).getString("week")
                fourweek.text = response.getJSONArray("weatherForecast").getJSONObject(4).getString("week")
                fiveweek.text = response.getJSONArray("weatherForecast").getJSONObject(5).getString("week")
                sixweek.text = response.getJSONArray("weatherForecast").getJSONObject(6).getString("week")
                sevenweek.text = response.getJSONArray("weatherForecast").getJSONObject(7).getString("week")

                var next1DayTemperature = response.getJSONArray("weatherForecast").getJSONObject(1).getJSONObject("forecastMaxtemp").getString("value")
                var next2DayTemperature = response.getJSONArray("weatherForecast").getJSONObject(2).getJSONObject("forecastMaxtemp").getString("value")
                var next3DayTemperature = response.getJSONArray("weatherForecast").getJSONObject(3).getJSONObject("forecastMaxtemp").getString("value")
                var next4DayTemperature = response.getJSONArray("weatherForecast").getJSONObject(4).getJSONObject("forecastMaxtemp").getString("value")
                var next5DayTemperature = response.getJSONArray("weatherForecast").getJSONObject(5).getJSONObject("forecastMaxtemp").getString("value")
                var next6DayTemperature = response.getJSONArray("weatherForecast").getJSONObject(6).getJSONObject("forecastMaxtemp").getString("value")
                var next7DayTemperature = response.getJSONArray("weatherForecast").getJSONObject(7).getJSONObject("forecastMaxtemp").getString("value")
                next1DayTemp.text = String.format("%s%s",next1DayTemperature.toString(), getString(R.string.tempC))
                next2DayTemp.text = String.format("%s%s",next2DayTemperature.toString(), getString(R.string.tempC))
                next3DayTemp.text = String.format("%s%s",next3DayTemperature.toString(), getString(R.string.tempC))
                next4DayTemp.text = String.format("%s%s",next4DayTemperature.toString(), getString(R.string.tempC))
                next5DayTemp.text = String.format("%s%s",next5DayTemperature.toString(), getString(R.string.tempC))
                next6DayTemp.text = String.format("%s%s",next6DayTemperature.toString(), getString(R.string.tempC))
                next7DayTemp.text = String.format("%s%s",next7DayTemperature.toString(), getString(R.string.tempC))
            },

            Response.ErrorListener { error ->
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            }

        )
                queue.add(request)
    }
        fun requestJSONToday() {
        val descTV = findViewById<TextView>(R.id.desc_TV)
        val UpdatetimeTV = findViewById<TextView>(R.id.Updatetime_TV)
        val url = "https://data.weather.gov.hk/weatherAPI/opendata/weather.php?dataType=flw&lang=en"
        val queue = Volley.newRequestQueue(this)
        val request: JsonObjectRequest = JsonObjectRequest (
            Request.Method.GET,
            url,
            null,
            Response.Listener { response ->
                descTV.text = response.getString("forecastDesc")
                UpdatetimeTV.text = response.getString("updateTime")
            },
            Response.ErrorListener { error ->
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            }
        )
        queue.add(request)
    }//end here
}