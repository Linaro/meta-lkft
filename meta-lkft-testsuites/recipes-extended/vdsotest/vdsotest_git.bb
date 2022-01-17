SUMMARY = "vdsotest is a utility for testing and benchmarking a Linux VDSO."
DESCRIPTION = "vdsotest is a utility for testing and benchmarking a Linux VDSO. C library support for the VDSO is not necessary to use vdsotest."
HOMEPAGE = "https://github.com/nathanlynch/vdsotest"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://github.com/nathanlynch/vdsotest.git;protocol=https;branch=main"
SRCREV = "d6d600a1b2d82ea59111e060214bd3433524509d"

S = "${WORKDIR}/git"

inherit autotools
