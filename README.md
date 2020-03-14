# mobile  
[![Build Status](http://149.156.146.249:60001/jenkins/job/mobile/job/master/badge/icon?style=flat-square)](http://149.156.146.249:60001/jenkins/job/mobile/job/master/)

## Setup
 1. Clone repository
 2. Disable line ending normalisation  
  ```git config core.autocrlf false```
 3. Open project in Intellij IDEA/Android Studio

## Working with project
Build project:  
```./gradlew build```

Run tests:  
```./gradlew test```

Run instrumented test on device:  
```./gradlew connectedAndroidTest```

Fix checkstyle issues:  
```./gradlew ktlintFormat```

## Git:
### Commits
* Separate subject from body with a blank line
* Do not end the subject line with a period
* Capitalize the subject line and each paragraph
* Use the imperative mood in the subject line
* Wrap lines at 72 characters
* Use the body to explain what and why you have done something. In most cases, you can leave out details about how a change has been made.  

##### E.g.:
    ```
    Add CPU arch filter scheduler support
    
    In a mixed environment of…
    ```
### Branches
* Choose *short* and *descriptive* names:

  ```shell
  # good
  $ git checkout -b oauth-migration

  # bad - too vague
  $ git checkout -b login_fix
  ```

* Identifiers from corresponding tickets in a GitHub
  issue are also good candidates for use in branch names. For example:

  ```shell
  # GitHub issue #15
  $ git checkout -b issue-15
  ```

* Use lowercase in branch names. External ticket identifiers with uppercase
  letters are a valid exception. Use *hyphens* to separate words.

  ```shell
  $ git checkout -b new-feature      # good
  $ git checkout -b T321-new-feature # good (Phabricator task id)
  $ git checkout -b New_Feature      # bad
  ```

* When several people are working on the *same* feature, it might be convenient
  to have *personal* feature branches and a *team-wide* feature branch.
  Use the following naming convention:

  ```shell
  $ git checkout -b feature-a/master # team-wide branch
  $ git checkout -b feature-a/maria  # Maria's personal branch
  $ git checkout -b feature-a/nick   # Nick's personal branch
  ```

  Merge at will the personal branches to the team-wide branch (see ["Merging"](#merging)).
  Eventually, the team-wide branch will be merged to "master".

* Delete your branch from the upstream repository after it's merged, unless
  there is a specific reason not to.

  Tip: Use the following command while being on "master", to list merged
  branches:  
  
  un*x/BSD:
  ```shell
  $ git branch --merged | grep "\*"
  ```
  or Windows
  ```powershell
  > git branch --merged | Select-String -Pattern "\*" 
  ```

### Design:
  [Adobe XD](https://xd.adobe.com/view/71b0d38f-02fb-452f-4f07-58be0126f00e-0781/)
