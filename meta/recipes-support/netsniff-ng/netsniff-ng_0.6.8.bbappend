DEPENDS = "bison \
    flex \
    libcli \
    libnet \
    libpcap \
    ncurses \
"

do_install() {
    oe_runmake DESTDIR=${D} install_all
}
