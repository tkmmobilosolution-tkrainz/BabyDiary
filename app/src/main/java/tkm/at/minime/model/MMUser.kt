package tkm.at.minime.model

import tkm.at.minime.authentication.model.MMAuthentication

data class MMUser(val email: String, val userName: String, val childs: ArrayList<MMChild>,
                  val uuid: String = MMAuthentication().userUUID())