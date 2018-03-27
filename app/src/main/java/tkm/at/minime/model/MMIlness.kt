package tkm.at.minime.model

data class MMIlness(val name: String, val description: ArrayList<String>?,
                    val startDate: Long = System.currentTimeMillis(), val endDate: Long)