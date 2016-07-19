# Java tools Makefile

# "make all"       - Make the various tools
# "make jdep"      - Make the Java class file dependency analyzer tool
# "make clean"     - Remove object and executable files

# C compiler
CC = gcc

CFLAGS = -g


# The directory where built executables go
BIN_DIR = ./bin

DIRS = $(BIN_DIR) 

all: jdep touchp

jdep: $(DIRS) $(BIN_DIR)/jdep

touchp: $(BIN_DIR) $(BIN_DIR)/touchp

$(BIN_DIR):
	mkdir -p $(BIN_DIR)

$(BIN_DIR)/jdep: jdep.c
	$(CC) $(CFLAGS) -o $@ jdep.c

$(BIN_DIR)/touchp: touchp.sh
	cp touchp.sh $@
	chmod +x $@

.PHONY: all jdep touchp clean

clean:
	rm -rf $(BIN_DIR)/jdep $(BIN_DIR)/touchp
