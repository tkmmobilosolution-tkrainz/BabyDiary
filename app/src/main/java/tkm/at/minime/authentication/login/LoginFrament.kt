package tkm.at.minime.authentication.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import tkm.at.minime.R
import tkm.at.minime.base.MMFragment
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.inputmethod.InputMethodManager
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.SingleSubject

/**
 * [Add class description here]
 *
 * Created 27.03.18
 *
 * @author Thomas Krainz-Mischitz (Level1 GmbH)
 * @version %I%, %G%
 */
class LoginFragment: MMFragment() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var createAccountButton: Button

    val registrationClicked = PublishSubject.create<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.login_fragment, container, false)

        emailEditText = view.findViewById(R.id.emailET)
        emailEditText.setOnFocusChangeListener { v, hasFocus ->
            var hintText = ""
            if (!hasFocus) hintText = "Email Adresse"
            emailEditText.hint = hintText
            emailEditText.isCursorVisible = hasFocus
        }

        passwordEditText = view.findViewById(R.id.passwordET)
        passwordEditText.setOnFocusChangeListener { v, hasFocus ->
            var hintText = ""
            if (!hasFocus) hintText = "Passwort"
            passwordEditText.hint = hintText
            passwordEditText.isCursorVisible = hasFocus
        }
        passwordEditText.setOnEditorActionListener( { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                //Clear focus here from edittext
                //passwordEditText.isFocusable = false
            }
            false
        })

        createAccountButton = view.findViewById(R.id.createAccountButton)
        createAccountButton.setOnClickListener {
            registrationClicked.onNext("")
        }

        return view
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}