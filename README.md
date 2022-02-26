# aws-sample
AWS sample code to store, fetch, delete in aws-s3

git config --global user.name <username>
git config --global user.email <email>
Follow below process if authentication is failing 
  **Create Personal Access Token on GitHub**<br>
     **From your GitHub account, go to **<br>
   Settings => Developer Settings 
                => Personal Access Token 
                => Generate New Token (Give your password) 
                => Fillup the form 
                => click Generate token 
                => Copy the generated Token, 
  it will be something like ghp_sFhFsSHhTzMDreGRLjmks4Tzuzgthdvfsrta
  
  _**For Windows OS ⤴**_
    Go to 
    Credential Manager from Control Panel 
        => Windows Credentials 
        => find git:https://github.com 
        => Edit 
        => On Password replace with with your GitHub Personal Access Token 
        => You are Done
    
    If you don’t find git:https://github.com => 
        Click on Add a generic credential 
        => Internet address will be git:https://github.com 
        => you need to type in your username and password will be your GitHub Personal Access Token 
        => Click Ok and you are done
  
git clone https://github.com/awajay/aws-sample.git

