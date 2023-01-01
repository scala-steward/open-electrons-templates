## open-electrons-known-issues

This document contains several known issues and their resolution that was encountered during the development of this
project.

### GitHub Actions

1. For capturing changelog during releases, we use this [GitHub action](https://github.com/metcalfc/changelog-generator) 
   and it contains a known issue where for a GitHub project, if there are no releases set up, it results in a weird
   _"Error Not Found"_ error as documented [here](https://github.com/metcalfc/changelog-generator#troubleshooting).
   
   The fix for this is to create an annotated tag, push the tag and then navigate to the project in GitHub and convert
   a tag to a Release. After this the error should not show up again.