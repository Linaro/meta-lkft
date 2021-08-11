SUMMARY = "Linux Kernel Selftests (mainline)"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v5.x/linux-${PV}.tar.xz"
# Patches inappropriate or not yet merged by upstream
# Some patches may have been submitted to upstream
SRC_URI += "\
    file://0001-selftests-lib-allow-to-override-CC-in-the-top-level-Makefile-v5.12.patch \
"

SRC_URI[md5sum] = "f1ce10256453cb1746536d09f9daf263"
SRC_URI[sha256sum] = "72fe7cc1f0363523061659a21e24754697b27f405cb88a41a63038629636159a"

S = "${WORKDIR}/linux-${PV}"

export INSTALL_PATH = "/opt/kselftests/mainline"

require kselftests-common.inc
