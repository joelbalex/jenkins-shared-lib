import jenkins.model.Jenkins
import hudson.model.Result

def getSuccessfulBuilds(String jobName) {
    def job = Jenkins.instance.getItem(jobName)
    if (job == null) { return [] }
    return job.builds.findAll { it.result == Result.SUCCESS }
                    .collect { it.number as String }
}
