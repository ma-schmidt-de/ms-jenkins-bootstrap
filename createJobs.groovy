pipelineJob('pipelineJob') {
    definition {
        cps {
            script(readFileFromWorkspace('jobs/pipelineJob.groovy'))
            sandbox()
        }
    }
}