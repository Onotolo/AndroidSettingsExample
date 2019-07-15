package my.onotolo.android.andrset.example.settings

import my.onotolo.andrset.SettingsProvider

object AppSettingsProvider: SettingsProvider() {
    override var PREFS_NAME = APP_SETTINGS_FILE_NAME
}