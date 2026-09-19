# den-patch

Local APK patches for the Imou Android app.

## Imou no-promotions patch

The patch targets Imou package `com.mm.android.smartlifeiot` and disables the native Imou Protect promotional banner and renewal/VAS dialog layouts.

This repository stores **patch sources**, not vendor APKs, signing keys, account data, or extracted app data.

### Build

Requirements: `apktool`, `zipalign`, `apksigner`, and `keytool`.

```bash
./patch-imou.sh /path/to/original.apk output.apk
```

The script decodes the APK, applies only the layout changes, rebuilds, zip-aligns, and signs it with a caller-provided keystore. It does not install or handle credentials.

Modified APKs are unsigned with the original vendor signature and may require uninstalling the official app first. Preserve the original APK for rollback.
