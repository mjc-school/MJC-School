## Linux & Bash

#### Linux Topics
- Structure, File System
    - What are the basic components of Linux?
    - What is FHS?
    - What is directory?
    - File permissions
    - why do we need e on directories
    - Link types
    - inode
- Base Linux commands
    - Be familiar with high level syntax of base linux commands, like 
        - file system commands, actions with files and directories
        - string manipulation commands and file editors
        - process management commands
    - How to create variable? Function?
    - Users, groups and their permissions
    
__Links:__
- [UNIX / LINUX Tutorial](https://www.tutorialspoint.com/unix/index.htm)
- [Inode explanation](http://teaching.idallen.com/cst8207/13w/notes/450_file_system.html#things-are-stored-in-index-nodes-inodes)

#### Bash Topics
- Bash (syntax/features/etc.)
    - Ways to sun sh script?
    - What's the difference between single and double quotes? 
- Bash control flow chars ( | , &, &&, ||, >, <, etc.)

__Links:__ 
- [Advanced Bash-Scripting Guide](https://tldp.org/LDP/abs/html/index.html)

## Task

__Deadline:__ 4 working days.  

__Disclaimer:__ In case of any questions related to the task please immediately contact any of the mentors to avoid misunderstanding.

#### Legend
After successful implementation of the task you should have a script which can help you easily preconfigure the fresh virtual machine with all required tools.

#### Workplace Setup
- Setup virtual machine with [CentOS 6.0 x86_64](https://sourceforge.net/projects/virtualboximage/files/CentOS/6.0/CentOS-6-x86_64.7z/download) on board (Credentials: _root/reverse_). 
- This virtual machine has wrong keyboard layout settings. It's highly recommended to change it.
- Make sure that VM has proper internet connection and accessible via SSH (your interaction with the VM should be mainly through SSH).
- Create another user with limited permissions to system folders.

#### Environment Setup
Write environment setup Bash script, which should be able to:

- Execute in __batch mode__ (no user interactions while script execution).
- Install all necessary applications for Java development like Maven, Git, Java, PostgreSQL, etc. (feel free to add other tools in case you need them)
- Preconfigure several settings (if the tool installation require any interaction) by passing corresponding script parameters.
- Skip some installation stages by a parameter (or the script should check if the tool installed and skip the installation by itself).
- Perform all necessary input and path validations, check that required services running, perform error handling.
- Print user-friendly output during script execution. Consider providing ability to enable/disable non-script output (i.e. preserve only script-specific echo output) at all through an option `-v`/`--verbose`. 
- Show Unix-like help message which describes all features and usage of the script (refer help messages of several standard Unix tools as an example).
- Refer [Google Shell Style Guide](https://google.github.io/styleguide/shell.xml) to make your code more readable and [Shell Check](https://www.shellcheck.net/) to avoid common mistakes.

The script is supposed to be executed from the root user. Feel free to add any additional features to your script (note that this also should be documented in the help message).

#### Required technologies to be used
- Oracle VM VirtualBox.
- [CentOS 6.0 x86_64](https://sourceforge.net/projects/virtualboximage/files/CentOS/6.0/CentOS-6-x86_64.7z/download) (without GUI, Credentials: _root/reverse_).
- PostgreSQL 9.4 or higher.
- Java 1.8 or higher.

#### Acceptance
- Reviewee should demonstrate the script execution on a clean OS (no java, maven, etc).
- After script execution reviewee is able to use all installed software without any additional actions.
- Script passes [Shell Check](https://www.shellcheck.net/) test (in exceptional cases the explanation of the decision should be leaved in a comment near to the suspicious line).