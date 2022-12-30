SUMMARY = "v4l2 and IR applications"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=48da9957849056017dc568bbc43d8975 \
                    file://COPYING.libv4l;md5=d749e86a105281d7a44c2328acebc4b0"
PROVIDES = "libv4l media-ctl"

DEPENDS = "jpeg \
           ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'virtual/libx11', '', d)}"
DEPENDS:append:libc-musl = " argp-standalone"
DEPENDS:append:class-target = " udev"
LDFLAGS:append = " -pthread"

inherit autotools gettext pkgconfig

PACKAGECONFIG ??= "media-ctl"
PACKAGECONFIG[media-ctl] = "--enable-v4l-utils,--disable-v4l-utils,,"

PV = "1.22.0+git"

SRC_URI = "git://git.linuxtv.org/v4l-utils.git;protocol=https;nobranch=1"
SRCREV = "ef51009796e75b4880773141805ddb16c9fe1e70"

S = "${WORKDIR}/git"
B = "${S}"

EXTRA_OECONF = "--disable-qv4l2 --enable-shared --with-udevdir=${base_libdir}/udev"

VIRTUAL-RUNTIME:ir-keytable-keymaps ?= "rc-keymaps"

PACKAGES =+ "media-ctl ir-keytable rc-keymaps libv4l libv4l-dev"

RPROVIDES:${PN}-dbg += "libv4l-dbg"

FILES_media-ctl = "${bindir}/media-ctl ${libdir}/libmediactl.so.*"

FILES:ir-keytable = "${bindir}/ir-keytable ${base_libdir}/udev/rules.d/*-infrared.rules"
RDEPENDS:ir-keytable += "${VIRTUAL-RUNTIME_ir-keytable-keymaps}"

FILES:rc-keymaps = "${sysconfdir}/rc* ${base_libdir}/udev/rc*"

FILES:${PN} = "${bindir} ${sbindir}"

FILES:libv4l += "${libdir}/libv4l*${SOLIBS} ${libdir}/libv4l/*.so ${libdir}/libv4l/plugins/*.so \
                 ${libdir}/libdvbv5*${SOLIBS} \
                 ${libdir}/libv4l/*-decomp"

FILES:libv4l-dev += "${includedir} ${libdir}/pkgconfig \
                     ${libdir}/libv4l*${SOLIBSDEV} ${libdir}/*.la \
                     ${libdir}/v4l*${SOLIBSDEV} ${libdir}/libv4l/*.la ${libdir}/libv4l/plugins/*.la"

PARALLEL_MAKE:class-native = ""
BBCLASSEXTEND = "native"

do_configure:prepend() {
    ${S}/bootstrap.sh
}
