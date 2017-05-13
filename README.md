# Version-Control-System-
Author Names : Parth Patel, Vishrut Shah, Jui Desai
Team Name : PVJ
Contact info :  
	Parth: parthashokbhai.patel@student.csulb.edu
	Vishrut: vishrutshah15@gmail.com
	Jui: jui1995@yahoo.in
Class Number: 10341(CECS 543)

Introduction : 
-The purpose of Source Code Management(SCM) is that it records changes to a file or set of files over time so that you can recall specific versions later.
-The part2 of SCM implements two usecase: Checkin Repo , Checkout Repo.
-Three commands are there in main method : create , checkin , checkout
-" create source_tree_path target_repo_folder " command will create new     files in the target folder. 
-checkin : " checkin source_tree_path target_repo_folder " command will create a new modified file in the same target sub folder.
-checkout: " checkout repo_folder destination_path " command will create a new project tree inside the empty target folder. The files will be those mentioned in the identified manifest file.
-An “artifact” is a version of a file. The SCM repository will hold multiple versions of a given file, to distinguish between two of its artifacts, 
within the repository a code name has been used for each artifact and all the artifacts of a particular file will be inside in a folder which has 
the original file's name.
-Manifest.txt file to support file path. It contains a record of user command's activity including code name of the project and repository creation date time.

External Requirements: Not needed

Build : JDK
Installation : 
	Requires Java (You can use command line/terminal or an IDE tool such as Intellij or Eclipse or NetBeans)
	How to Setup
	• Select VCS.jar file.
	• Compile and Run selected VCS.jar in terminal/command line.
	Or
	• Open Source.java file.
	• Compile and Run Source.java file.
	
	
Usage :
	• Run Project and use following commands.
	  Run: java -jar "<Jar file location>"
	
	• To Create a new Repo enter command:
	  create <Source Path> <Repo Path>
	  Example: Create F:\Source F:\Target
	
	• To Checkin a new Repo enter command:
	  checkin <Source Path> <Repo Path>
	  Example: checkin F:\Source F:\Target

	• To checkout a Repo enter command:
	  checkout <Repo Path> <Empty Folder Path>
	  Example: checkout F:\Target  F:\checkout
	  Above command will give List of Manifest files. Select the manifest file which you want to checkout.
	  Example:
		1 Manifest_20170511_0721.txt
		2 Manifest_20170511_0722.txt
		3 Manifest_20170511_0723.txt
		4 Manifest_20170511_0743.txt
		5 Manifest_20170511_0748(Checkout manifest) .txt
		6 Manifest_20170511_0749(Checkout manifest) .txt
		Enter number to select manifest file
		4



	

		  
Extra Features : None

Bugs : None
