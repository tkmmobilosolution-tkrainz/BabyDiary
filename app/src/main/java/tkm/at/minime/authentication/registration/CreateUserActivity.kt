package tkm.at.minime.authentication.registration

import android.os.Bundle
import tkm.at.minime.R
import tkm.at.minime.base.MMActivity

class CreateUserActivity: MMActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account_activity)
    }

    override fun onBackPressed() {
    }
}