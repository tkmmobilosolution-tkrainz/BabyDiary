package tkm.at.minime.authentication.model

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MMAuthentication {

    fun firebaseUser(): FirebaseUser? {
        return FirebaseAuth.getInstance().currentUser
    }
    fun isUserLoggedin(): Boolean {
        return firebaseUser() != null
    }

    fun userUUID(): String {
        val user = firebaseUser() ?: return ""
        return user.uid
    }
}