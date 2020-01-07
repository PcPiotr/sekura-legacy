package pl.redny.sekura.activity

import android.net.Uri

class ViewModel {

    var encryptedFilePath: Uri? = Uri.EMPTY
    var decryptedFilePath: Uri? = Uri.EMPTY
    var filePath: Uri? = Uri.EMPTY
    var longitude: Double = 0.0
    var latitude: Double = 0.0
}
