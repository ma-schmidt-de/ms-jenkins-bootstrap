pipelineJob('pipelineJobTemplate') {
    definition {
        cps {
            script(readFileFromWorkspace('jobs/pipelineJobTemplate.groovy'))
            sandbox()
        }
    }
}

pipelineJob('studio-service-job') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/ma-schmidt-de/spring-studios-service.git'
                    }
                    branch 'master'
                }
            }
        }
    }
}

pipelineJob('studio-service-job-docker') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/ma-schmidt-de/spring-studios-service.git'
                    }
                    branch 'master'
                    scriptPath('Jenkinsfile-docker')
                }
            }
        }
    }
}