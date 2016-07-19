# This is an example Makefile illustrating the use of the jdep utility to
# enable the incremental build of Java programs.
#
# The program it builds doesn't do anything interesting. It's sole purpose in
# life is to be compiled.

# Instructions:
# "make"           - Make Example.jar
# "make clean"     - Remove .class, .jar and .d files

MODULE_NAME = Example

# Java compiler
JAVAC = javac

# Compile flags
JFLAGS = -g

# The directory where the built jar file goes
JAR_DIR = bin

# The directory root where the Java source files are found
JAVA_DIR = java

# Package hierarchy root for this project
PACKAGE_PATH = com/fudco/jdepexample

# The directory root where compiled .class files go
CLASS_DIR = classes

# The directory root where generated .d files go
DEP_DIR = depend

EXAMPLE_SRC = $(shell cd $(JAVA_DIR); find com -name '*.java')
EXAMPLE_CLA = $(EXAMPLE_SRC:%.java=$(CLASS_DIR)/%.class)
EXAMPLE_DEP = $(EXAMPLE_SRC:%.java=$(DEP_DIR)/%.d)

DIRS = $(DEP_DIR) $(CLASS_DIR) $(JAR_DIR)

all: $(MODULE_NAME)

MODULE_NAME_TARGET = $(JAR_DIR)/$(MODULE_NAME).jar

$(MODULE_NAME): $(DIRS) $(MODULE_NAME_TARGET)

$(CLASS_DIR):
	mkdir -p $(CLASS_DIR)

$(DEP_DIR):
	mkdir -p $(DEP_DIR)

$(JAR_DIR):
	mkdir -p $(JAR_DIR)

$(MODULE_NAME_TARGET): $(EXAMPLE_CLA)
	$(JAVAC) $(JFLAGS) -d $(CLASS_DIR) -classpath $(CLASS_DIR) $(?:$(CLASS_DIR)/%.class=$(JAVA_DIR)/%.java)
	jdep -c $(CLASS_DIR) -j $(JAVA_DIR) -d $(DEP_DIR) $?
	cd $(CLASS_DIR); jar cf ../$@ `find com -name '*.class'`

.PHONY: all clean

clean:
	rm -rf $(CLASS_DIR)/$(PACKAGE_PATH) $(DEP_DIR)/$(PACKAGE_PATH) $(MODULE_NAME_TARGET)

$(CLASS_DIR)/%.class: $(JAVA_DIR)/%.java
	touchp $@

-include $(EXAMPLE_DEP)
