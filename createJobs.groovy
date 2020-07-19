pipelineJob('pipelineJobTemplate') {
    definition {
        cps {
            script(readFileFromWorkspace('jobs/pipelineJobTemplate.groovy'))
            sandbox()
        }
    }
}