##CSCI 201 Team Project Repository

###How to build me!

To build this project, you'll have to have working Android environment set up. We as a team have been using Android Studio, but you should be able to open and run Android projects with Android Studio, Eclipse, or IntelliJ. You should have the Android SDK and SDK tools installed on whatever IDE you choose. We personally opted to install this with [this link](https://developer.android.com/sdk/index.html) which gave us the Android Studio IDE, Android SDK tools, the Android 5.0 platform, and the Android 5.0 emulator system image. Installing all of this together simplified our environment set-up, and as Eclipse support is being eclipsed in favor of Android Studio by Google, we decided it would be better to opt for Android Studio over other IDE's.

Once you have a working Android environment set up, then you can just go to File -> Open and open wherever you have saved the project you want to open. Then, you can build and run by clicking the green triangle in the toolbar, or hit Run -> Run.

Once the app is loaded, login as a sample user of ours.
Username: BMoney
Password: password

###Contact Information
**Developer 1**:
  + Name: Trevor Cai
  + USC Email: tcai@usc.edu
  + Lecture Section: 30393

**Developer 2**:
  + Name: Joseph D. Goelz
  + USC Email: jgoelz@usc.edu
  + Lecture Section: 30381

**Developer 3**:
  + Name: Taegyum Kim
  + USC Email: taegyumk@usc.edu
  + Lecture Section: 30381

**Developer 4**:
  + Name: Winston Lee
  + USC Email: winstojl@usc.edu
  + Lecture Section: 30381

**Developer 5**:
  + Name: Joyce Yan
  + USC Email: joyceyan@usc.edu
  + Lecture Section: 30381

###Git Shit

Before you start working, checkout to a new branch. Remember to commit regularly!
```
git checkout -b my-feature
git commit -m "i made a change!"
git commit -m "here's another change!"
git commit -m "i commit regularly to properly utilize the advantages of distributed version control!"
```

If someone has pushed to master and you want their changes for your feature before you push onto master yourself, then pull from master and merge master onto your branch.
```
git checkout master
git pull
git checkout my-feature
git merge master
```

If you've already committed to master and didn't realize you had diverged until you tried pushing, then run a git pull and rebase your local changes onto master.
```
git pull --rebase
git push
```

When you are ready to deploy your feature, commit all your changes and run a git status to double check that all your changes are in. Then, checkout to master (and git pull to make sure you're up to date) and merge changes from your branch onto master. After your changes are properly merged from your local branch to your local copy of master, push from your local copy of master to the remote master.
```
git commit -m "here's my final change!"
git checkout master
git pull
git merge my-feature
git push
```

If you run into a merge conflict, run a "git status" to see which files have a conflict. Then, open these files directly, and manually merge the changes you want to see. When you are done, save the file, git add it, commit your changes, and then push.
```
git status

These files have a conflict:
asdf.txt

git add asdf.txt
git commit
git push
```

###Implementation ReadMe Additional Notes:

Users in the database are able to log in, using their correct passwords and usernames.
When they log in, potential matches (candidates) are show up and are able to be approved/denied via a swipe right or left
When a user clicks the logo at the top, the user is able to play the math mini game
When a user clicks the correct response to the question, then his/her score will increment (score denotes intelligence)
When a user clicks the incorrect response to the question, then his/her score will decrement
When a user clicks the settings button at the top left, he/she should be able to change his/her preferred age range in addition to his/her preferred intelligence levels
When the app is started, and a user presses the play without an account button, he/she is able to access the game

Our chat's sending feature is a bit buggy at the moment, but we plan on modifying this for the demo. The code is present, though.
In the back end, users' scores are updated while playing the game... but while users are playing the game, the popup displayed (signifying increment or decremnt of score) is not necessarily correct.


When attempting to log in, please use the username "BMoney" with the password as "password"