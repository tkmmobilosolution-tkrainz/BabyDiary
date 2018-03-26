package tkm.at.minime

import android.os.Bundle
import tkm.at.minime.base.MMActivity

class MainActivity : MMActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
