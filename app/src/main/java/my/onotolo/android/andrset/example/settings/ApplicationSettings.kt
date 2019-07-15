package my.onotolo.android.andrset.example.settings

import my.onotolo.android.andrset.example.R
import my.onotolo.andrset.Setting

const val APP_SETTINGS_FILE_NAME = "AppSettings"

sealed class ApplicationSetting<T>: Setting<T>() {
    override val settingsProvider = AppSettingsProvider
}
sealed class ApplicationEnumSetting<T>: Setting<T>() {
    override val settingsProvider = AppSettingsProvider
}

object IsImageShown: ApplicationSetting<Boolean>() {

    override val settingNameResId = R.string.set_is_image_shown

    override val descriptionResId = null

    override val id: String = "Is image shown"
    override val defaultValue = true
}

object ImageShrinkValue: ApplicationSetting<Int>() {

    override val settingNameResId = R.string.set_image_shrink

    override val descriptionResId = R.string.set_image_shrink_descr

    override val id: String = "Image shrink value"
    override val defaultValue = 1
}
