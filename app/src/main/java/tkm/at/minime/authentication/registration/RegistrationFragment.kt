package tkm.at.minime.authentication.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import io.reactivex.subjects.PublishSubject
import tkm.at.minime.R
import tkm.at.minime.base.MMFragment

/**
 * [Add class description here]
 *
 * Created 27.03.18
 *
 * @author Thomas Krainz-Mischitz (Level1 GmbH)
 * @version %I%, %G%
 */
class RegistrationFragment : MMFragment() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordET: EditText
    private lateinit var registrationButton: Button

    val registrationSuccessful = PublishSubject.create<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.registration_fragment, container, false)

        emailEditText = view.findViewById(R.id.emailRegistrationET)
        emailEditText.setOnFocusChangeListener { v, hasFocus ->
            var hintText = ""
            if (!hasFocus) hintText = "Email Adresse"
            emailEditText.hint = hintText
            emailEditText.isCursorVisible = hasFocus
        }

        passwordEditText = view.findViewById(R.id.passwordRegistrationET)
        passwordEditText.setOnFocusChangeListener { v, hasFocus ->
            var hintText = ""
            if (!hasFocus) hintText = "Passwort"
            passwordEditText.hint = hintText
            passwordEditText.isCursorVisible = hasFocus
        }

        confirmPasswordET = view.findViewById(R.id.confirmPasswordRegistrationET)
        confirmPasswordET.setOnFocusChangeListener { v, hasFocus ->
            var hintText = ""
            if (!hasFocus) hintText = "Passwort bestätigen"
            confirmPasswordET.hint = hintText
            confirmPasswordET.isCursorVisible = hasFocus
        }
        confirmPasswordET.setOnEditorActionListener({ v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                //Clear focus here from edittext
                //passwordEditText.isFocusable = false
            }
            false
        })

        registrationButton = view.findViewById(R.id.registrationButton)
        registrationButton.setOnClickListener {
            registrationSuccessful.onNext("")
        }

        return view
    }
}