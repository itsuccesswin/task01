#!groovy
 
import jenkins.model.*
import hudson.security.*
import jenkins.security.s2m.AdminWhitelistRule
import jenkins.model.JenkinsLocationConfiguration
import net.sf.json.JSONObject
 
def instance = Jenkins.getInstance()
String admin_email = 'jenkins-teama-dev@company.com'
JenkinsLocationConfiguration location = instance.getExtensionList('jenkins.model.JenkinsLocationConfiguration')[0]
 
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount("admin", "admin")
instance.setSecurityRealm(hudsonRealm)
 
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)
 
Jenkins.instance.getInjector().getInstance(AdminWhitelistRule.class).setMasterKillSwitch(false)
println "Updating Jenkins Email to: ${admin_email}"
location.adminAddress = admin_email
instance.save()
location.save()
