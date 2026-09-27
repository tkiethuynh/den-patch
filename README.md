# 🧩 Den Patches

Custom Morphe patches for Android applications, maintained by Kiet Huynh.

---

## 📱 Supported Applications

### 1. Sổ Thu Chi MISA (`vn.com.misa.sothuchi`)
- **Compatibility**: Version `93.4` (arm64-v8a)
- **Patches**:
  - `Unlock premium`: Unlocks all premium reporting and expense tracking features, suppresses advertisements.
  - `Remove split requirements`: Strips `requiredSplitTypes` and split metadata from `AndroidManifest.xml` to allow installing as a standalone APK without split install failures (`INSTALL_FAILED_MISSING_SPLIT`).

### 2. Imou Life (`com.mm.android.smartlifeiot`)
- **Compatibility**: Version `8.3.0`
- **Patches**:
  - `Remove Imou promotions`: Suppresses native Imou Protect promotional banners and subscription renewal dialogs.

---

## 📦 Releases & Installation

### Using with Morphe Manager
Add this repository as a custom source in Morphe Manager:
```
https://github.com/tkiethuynh/den-patch
```

### Using with Morphe CLI
Download the latest patch bundle (`den-patch-<version>.mpp` or `.jar`) from [Releases](https://github.com/tkiethuynh/den-patch/releases/latest):

```bash
java -jar morphe-cli.jar patch \
  --patches den-patch-1.0.0.mpp \
  --out app_patched.apk \
  app_base.apk
```

---

## 🛠️ Building from Source

### Prerequisites
- JDK 21
- Gradle (wrapper included)

### Build Command
```bash
./gradlew buildAndroid
```

Artifacts are produced in `build/libs/`:
- `den-patch-<version>.jar`
- `den-patch-<version>.mpp`

---

## 📜 License

Den Patches are licensed under the [GNU General Public License v3.0](LICENSE).
