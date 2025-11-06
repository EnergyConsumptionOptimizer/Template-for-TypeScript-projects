import com.github.gradle.node.npm.task.NpmTask
import io.github.andreabrighi.gradle.gitsemver.conventionalcommit.ConventionalCommit

plugins {
    application
    alias(libs.plugins.node)
    alias(libs.plugins.gitSemVer)
}

node {
    version.set("22.21.0")
    download.set(true)
    nodeProjectDir.set(file(project.projectDir))
}

buildscript {
    dependencies {
        classpath("io.github.andreabrighi:conventional-commit-strategy-for-git-sensitive-semantic-versioning-gradle-plugin:1.0.15")
    }
}
gitSemVer {
    commitNameBasedUpdateStrategy(ConventionalCommit::semanticVersionUpdate)
    minimumVersion.set("0.1.0")
}