package app.tkiethuynh.patches.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

object Constants {
    val COMPATIBILITY_IMOU = Compatibility(
        name = "Imou Life",
        packageName = "com.mm.android.smartlifeiot",
        apkFileType = ApkFileType.APK,
        appIconColor = 0xFFF28C00,
        targets = listOf(
            AppTarget(version = "8.3.0")
        )
    )
}
