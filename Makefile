# SPDX-License-Identifier: AGPL-3.0-or-later

all: build-ant

include build.mk

install:
	cp build/zm-taglib-*.jar build/zm-taglib.jar
	$(call install_wa_service_lib, build/zm-taglib.jar)
	$(call install_jar_lib, build/zm-taglib.jar)
	$(call install_jetty_lib, build/UserAgentUtils-1.21.jar)

clean: clean-ant
