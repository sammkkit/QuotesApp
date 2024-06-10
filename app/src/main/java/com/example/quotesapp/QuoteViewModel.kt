import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateOf
import com.example.quotesapp.Quote
import com.example.quotesapp.RetrofirInstance
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    private val _quote = mutableStateOf<Quote?>(null)
    val quote  = _quote.value

    fun getQuote() {
        viewModelScope.launch {
            try {
                val response = RetrofirInstance.quoteapi.getQuote()
                if (response.isSuccessful) {
                    _quote.value = response.body()
                }
            } catch (e: Exception) {
                error("error")
            }
        }
    }
}
