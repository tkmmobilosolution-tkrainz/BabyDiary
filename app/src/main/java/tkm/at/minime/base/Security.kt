package tkm.at.minime.base

/**
 * [Add class description here]
 *
 * Created 26.03.18
 *
 * @author Thomas Krainz-Mischitz (Level1 GmbH)
 * @version %I%, %G%
 */
class Security {

    private val admobIdString = "ca-app-pub-9184630521515163~7785854166"

    fun admobId(): String {
        return admobIdString
    }
}