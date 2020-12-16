# java_test
这是一份软件工程过程的作业  
一：创建版本库。  
通过命令 git init 把这个目录变成git可以管理的仓库，如下：  
第一步：使用命令 git add readme.txt添加到暂存区里面去。如下：  
第二步：用命令 git commit告诉Git，把文件提交到仓库。  
二：版本回退：  
可以使用如下2种命令，第一种是：git reset --hard HEAD^ 那么如果要回退到上上个版本只需把HEAD^ 改成 HEAD^^ 以此类推。那如果要回退到前100个版本的话，使用上面的方法肯定不方便，我们可以使用下面的简便命令操作：git reset --hard HEAD~100 即可。  
三：理解工作区与暂存区的区别  
第一步：是使用 git add 把文件添加进去，实际上就是把文件添加到暂存区。  
第二步：使用git commit提交更改，实际上就是把暂存区的所有内容提交到当前分支上。  
四：Git撤销修改和删除文件操作。  
一：撤销修改：  
我可以按以前的方法直接恢复到上一个版本。使用 git reset --hard HEAD^  
二：删除文件。  
可以使用如下命令 git checkout -- b.txt  
  
我自己github的项目地址：  
https://github.com/Dnkiss/OSUAssistant
