package tkm.at.minime.model

import java.util.Date

/**
 * [Add class description here]
 *
 * Created 26.03.18
 *
 * @author Thomas Krainz-Mischitz (Level1 GmbH)
 * @version %I%, %G%
 */
data class MMData(val height: Int, val weight: Double, val date: Long = System.currentTimeMillis())