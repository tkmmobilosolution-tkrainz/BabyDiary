package tkm.at.minime.model

import java.util.Date

data class MMChild(val name: String?, val dateOfBirth: Date, val isBorn: Boolean, val gender: MMGender, val datas: ArrayList<MMData>?,
                   val ilnesses: ArrayList<MMIlness>?, val fever: ArrayList<MMFever>?, val events: ArrayList<MMEvent>?,
                   val vaccinations: ArrayList<MMVaccination>?, val teeth: ArrayList<MMTeeth>?, val breastfeed: ArrayList<MMBreastfeed>)