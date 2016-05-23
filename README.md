![ModHelp](https://github.com/pavog/ModHelp/logo.png)
=========

ModHelp
-------------------------------------------------
This Spigot plugin makes the life for the moderators and administrators of your
server easier by providing them the abilities to kick, ban, mute and warn players
which behaviours are not in line with your servers rules.

# Features
- Ban players
  - Ban a player with a reason
  - Tempban a player with a reason
- Kick players
  - Kick a player with a reason
- Mute players
  - Mute a player with a reason
  - Tempmute a player with a reason
  - Mute all players (e.g. for broadcasts)
- Warn players
  - Warn a player with a reason

- UUID support
- Multilanguage wiki for easy setup and configuration
- Reasons can be preconfigured and simply accessed by just using the id instead of the full reason text
- Tempbans & tempmutes can be seperated into seconds, minutes, hours, days, weeks, months, years
- Configurable events on x warnings (eg. tempban a player which has 10 warns)
- Synchronized via MySQL database
- (Optional) Website for lookup of past plugin events (bans, mutes, kicks, etc.)

- Open source
- Ready for recommendations   

# Usage

## Install the plugin
- Open your server folder
- Open your plugins folder
- Drag and drop the plugin
- Start or reload your server to activate the plugin
- (The plugin will shut down automatically because it's not configured)
- Edit the config.yml file and insert your database credentials
- (Optional) edit the messsages.yml file
- Stop and start your server or reload your server to activate the plugin again
- Check if it throws error messages (if it does repeat the 3 steps before)
- Log into your server via minecraft and try the plugin by executing the command /modhelp

## Config file
During setup the configuration file (config.yml) will be created for you (in /plugins/ModHelp/config.yml):
- TODO Config file explanation here


## Commands and permissions
- **/modhelp**
  - /modhelp info 

# License
The MIT License (MIT)

Copyright (c) 2016 Paul Vogel

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
