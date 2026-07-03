def call() {
    if (isMainBranch()) {
        echo "C'est la branche principale"
    } else {
        echo "Ce n'est pas la branche principale"
    }
}

def isMainBranch() {
    return env.BRANCH_NAME == 'main'
}
