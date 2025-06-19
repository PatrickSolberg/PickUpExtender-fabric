# Semantic Versioning Guide

This project uses semantic versioning with automatic versioning for different build types (dev, production, release).

## Version Format

The version follows the format: `MAJOR.MINOR.PATCH[-PRERELEASE][+BUILD]`

### Examples:
- `1.0.0` - Release version
- `1.0.0-alpha.1` - Alpha prerelease
- `1.0.0-beta.2` - Beta prerelease
- `1.0.0-rc.1` - Release candidate
- `1.0.0+dev.20231201.143022` - Development build with timestamp
- `1.0.0+mc.1.21.5` - Production build with Minecraft version
- `1.0.0+20231201` - Release build with build metadata

## Build Types

### Development Builds (`build_type=dev`)
- **Format**: `MAJOR.MINOR.PATCH+dev.YYYYMMDD.HHMMSS`
- **Example**: `1.0.0+dev.20231201.143022`
- **Use case**: For testing and development
- **JAR name**: `pickupextender-dev-1.0.0+dev.20231201.143022.jar`

### Production Builds (`build_type=production`)
- **Format**: `MAJOR.MINOR.PATCH+mc.MINECRAFT_VERSION`
- **Example**: `1.0.0+mc.1.21.5`
- **Use case**: For distribution and mod platforms
- **JAR name**: `pickupextender-production-1.0.0+mc.1.21.5.jar`

### Release Builds (`build_type=release`)
- **Format**: `MAJOR.MINOR.PATCH[+BUILD]`
- **Example**: `1.0.0` or `1.0.0+20231201`
- **Use case**: For official releases
- **JAR name**: `pickupextender-1.0.0.jar`

## Available Tasks

### Version Information
```bash
./gradlew versionInfo
```
Shows current version information including build type, version, and dependencies.

### Version Incrementing
```bash
# Increment patch version (1.0.0 → 1.0.1)
./gradlew incrementPatch

# Increment minor version (1.0.0 → 1.1.0)
./gradlew incrementMinor

# Increment major version (1.0.0 → 2.0.0)
./gradlew incrementMajor
```

### Prerelease Management
```bash
# Set prerelease version
./gradlew setPrerelease -Pprerelease=alpha.1
./gradlew setPrerelease -Pprerelease=beta.2
./gradlew setPrerelease -Pprerelease=rc.1

# Clear prerelease version
./gradlew clearPrerelease
```

### Build Type Management
```bash
# Set build type
./gradlew setBuildType -PbuildType=dev
./gradlew setBuildType -PbuildType=production
./gradlew setBuildType -PbuildType=release
```

### Building
```bash
# Build development version
./gradlew buildDev

# Build production version
./gradlew buildProduction

# Build release version
./gradlew buildRelease

# Clean and build
./gradlew cleanBuildDev
./gradlew cleanBuildProduction
```

## Configuration

Version settings are stored in `gradle.properties`:

```properties
# Semantic Versioning
mod_version_major=1
mod_version_minor=0
mod_version_patch=0
mod_version_prerelease=
mod_version_build=

# Build Configuration
build_type=dev
build_number=0
```

## Workflow Examples

### Development Workflow
1. Start with dev build type (default)
2. Make changes and test
3. Build: `./gradlew buildDev`
4. Test the generated JAR

### Release Preparation
1. Set prerelease if needed: `./gradlew setPrerelease -Pprerelease=beta.1`
2. Build: `./gradlew buildProduction`
3. Test thoroughly
4. Clear prerelease: `./gradlew clearPrerelease`
5. Increment version: `./gradlew incrementPatch`
6. Build release: `./gradlew buildRelease`

### Hotfix Workflow
1. Increment patch: `./gradlew incrementPatch`
2. Build production: `./gradlew buildProduction`
3. Test and distribute

## Best Practices

1. **Development**: Use `buildDev` for testing and development
2. **Testing**: Use `buildProduction` with prerelease tags for beta testing
3. **Release**: Use `buildRelease` for official releases
4. **Versioning**: Follow semantic versioning principles:
   - MAJOR: Breaking changes
   - MINOR: New features, backward compatible
   - PATCH: Bug fixes, backward compatible

## File Locations

- **Development builds**: `build/libs/pickupextender-dev-*.jar`
- **Production builds**: `build/libs/pickupextender-production-*.jar`
- **Release builds**: `build/libs/pickupextender-*.jar`

## Integration with CI/CD

You can integrate this versioning system with CI/CD pipelines:

```yaml
# Example GitHub Actions workflow
- name: Build Development Version
  run: ./gradlew buildDev

- name: Build Production Version
  run: ./gradlew buildProduction

- name: Build Release Version
  run: ./gradlew buildRelease
``` 