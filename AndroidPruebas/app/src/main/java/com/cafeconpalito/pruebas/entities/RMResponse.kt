
import com.google.gson.annotations.SerializedName

data class RMResponse(

	@SerializedName("info") val info : Info ?= null,
	@SerializedName("results") val results: List<Characters> ?= null
)