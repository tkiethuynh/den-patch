PACKAGE := com.mm.android.smartlifeiot
VERSION := 8.3.0
PATCH_JAR := build/libs/den-patch-1.0.0.jar
MORPHE_CLI := tools/morphe-cli.jar
APK := $(HOME)/Downloads/imou-8.3.0.apk
PATCHED := build/imou-8.3.0-patched.apk

.PHONY: build list patch clean

build:
	./gradlew jar --no-daemon

list: build
	java -jar $(MORPHE_CLI) list-patches $(PATCH_JAR)

patch: build
	@test -f "$(APK)" || (echo "Set APK=/path/to/original.apk"; exit 1)
	mkdir -p build
	java -jar $(MORPHE_CLI) patch -p $(PATCH_JAR) -o $(PATCHED) "$(APK)"
	@echo "Created $(PATCHED)"

clean:
	./gradlew clean --no-daemon
	rm -f $(PATCHED)
