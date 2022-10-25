# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository

$ git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test
Cloning into 'OOP-git-merge-conflict-test'...
remote: Enumerating objects: 12, done.
remote: Counting objects: 100% (4/4), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8
Receiving objects: 100% (12/12), done.
Resolving deltas: 100% (2/2), done.

2. Ci si assicuri di avere localmente entrambi i branch remoti

$ git log --all
commit bed943fbdd6ba94e64197448e4754a529d984e88 (origin/feature)
Author: Danilo Pianini <danilo.pianini@gmail.com>
Date:   Thu Oct 27 17:21:22 2016 +0200

    Print author information

commit 8e0f29c12e060f3bdc62540343eff3e473616d61 (HEAD -> master, origin/master, origin/HEAD)
Author: Danilo Pianini <danilo.pianini@gmail.com>
Date:   Thu Oct 27 17:19:05 2016 +0200

    Change HelloWorld to print the number of available processors

commit d956df66aeb0829f23b7b3d0d9a1c002c390f87f
Author: Danilo Pianini <danilo.pianini@gmail.com>
Date:   Thu Oct 27 17:17:43 2016 +0200

    Create .gitignore

commit 700ee0b669f6cd75384abb9af51ca5c2adefe917
Author: Danilo Pianini <danilo.pianini@gmail.com>
Date:   Thu Oct 27 17:15:10 2016 +0200

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`

$ git merge origin/feature
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.

4. Si noti che viene generato un **merge conflict**!

eh ho visto

5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)

$ java HelloWorld
This program is running in a PC with 12 logic processors!
This program has been realised by Danilo Pianini

STUDENTI+leonardo.tassinari6@lab22-05-02 MINGW64 ~/Desktop/OOP-git-merge-conflict-test (master|MERGING)
$ git status
On branch master
Your branch is up to date with 'origin/master'.

You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
        both modified:   HelloWorld.java

no changes added to commit (use "git add" and/or "git commit -a")

STUDENTI+leonardo.tassinari6@lab22-05-02 MINGW64 ~/Desktop/OOP-git-merge-conflict-test (master|MERGING)
$ git add .

STUDENTI+leonardo.tassinari6@lab22-05-02 MINGW64 ~/Desktop/OOP-git-merge-conflict-test (master|MERGING)
$ git commit -m "merged correctly"
[master 7a5ebee] merged correctly
 Committer: Leonardo Tassinari - leonardo.tassinari6@studio.unibo.it <leonardo.tassinari6@studio.unibo.it>
Your name and email address were configured automatically based
on your username and hostname. Please check that they are accurate.
You can suppress this message by setting them explicitly. Run the
following command and follow the instructions in your editor to edit
your configuration file:

    git config --global --edit

After doing this, you may fix the identity used for this commit with:

    git commit --amend --reset-author


STUDENTI+leonardo.tassinari6@lab22-05-02 MINGW64 ~/Desktop/OOP-git-merge-conflict-test (master)
$ git log --all --graph --oneline
*   7a5ebee (HEAD -> master) merged correctly
|\
| * bed943f (origin/feature) Print author information
* | 8e0f29c (origin/master, origin/HEAD) Change HelloWorld to print the number of available processors
|/
* d956df6 Create .gitignore
* 700ee0b Create HelloWorld


6. Si crei un nuovo repository nel proprio github personale
fatto tramite github
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote

$ git remote add ghub git@github.com:leo-tasso/lab6git.git

STUDENTI+leonardo.tassinari6@lab22-05-02 MINGW64 ~/Desktop/OOP-git-merge-conflict-test (master)
$ git remote -v
ghub    git@github.com:leo-tasso/lab6git.git (fetch)
ghub    git@github.com:leo-tasso/lab6git.git (push)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (fetch)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (push)

8. Si faccia push del branch `master` sul proprio repository
$ git push -u online master
Enumerating objects: 15, done.
Counting objects: 100% (15/15), done.
Delta compression using up to 12 threads
Compressing objects: 100% (11/11), done.
Writing objects: 100% (15/15), 1.58 KiB | 806.00 KiB/s, done.
Total 15 (delta 4), reused 10 (delta 2), pack-reused 0
remote: Resolving deltas: 100% (4/4), done.
To https://github.com/leo-tasso/lab6git.git
 * [new branch]      master -> master
branch 'master' set up to track 'online/master'.

STUDENTI+leonardo.tassinari6@lab22-05-02 MINGW64 ~/Desktop/OOP-git-merge-conflict-test (master)
$ git status
On branch master
Your branch is up to date with 'online/master'.

nothing to commit, working tree clean

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale

gia fatto con il -u

altrimenti

git branch --set-upstream-to=online/master
