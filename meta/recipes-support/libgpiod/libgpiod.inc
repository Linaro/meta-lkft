SUMMARY = "C library and tools for interacting with the linux GPIO character device"

LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=2caced0b25dfefd4c601d92bd15116de"

SRC_URI = "https://www.kernel.org/pub/software/libs/libgpiod/${BP}.tar.xz"

inherit autotools pkgconfig

PACKAGECONFIG[tests] = "--enable-tests,--disable-tests,kmod udev"

EXTRA_OECONF = "--enable-tools"

PACKAGES =+ " ${PN}-tools"

FILES:${PN}-tools = "${bindir}/*"

PACKAGES =+ "libgpiodcxx"
FILES:libgpiodcxx = "${libdir}/libgpiodcxx.so.*"