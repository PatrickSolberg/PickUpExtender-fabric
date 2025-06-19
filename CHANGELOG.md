# Changelog

All notable changes to PickUp Extender will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added
- Nothing yet

### Changed
- Nothing yet

### Deprecated
- Nothing yet

### Removed
- Nothing yet

### Fixed
- Nothing yet

### Security
- Nothing yet

---

## [1.0.1] - 2025-06-19

### Fixed
- **Hotkey reliability issues** - The "P" key toggle now responds immediately without delays or queuing
- **Key handling performance** - Hotkeys are now processed every client tick for consistent responsiveness
- **Mixin conflicts** - Resolved startup crashes related to InGameHud mixin
- **Build system stability** - Improved mixin application and error handling

### Changed
- **Hotkey processing** - Moved from ItemEntity.tick() to MinecraftClient.tick() for better reliability
- **Build system** - Implemented semantic versioning with automatic dev/production builds
- **Code organization** - Improved separation of concerns between pickup logic and key handling

### Technical
- **Semantic versioning** - Automatic versioning system with separate build types
- **Build pipeline** - Added `buildDev`, `buildProduction`, and `buildRelease` tasks
- **Version management** - Added tasks for incrementing versions and managing prereleases

### Known Issues
- HUD status overlay temporarily disabled (visual only, doesn't affect functionality)

---

## [1.0.0] - 2025-06-19

### Added
- **Extended pickup range** - Pick up items from 1-20 blocks away (configurable)
- **Hotkey system** - Quick access to toggle and adjust settings in-game
  - **P** - Toggle PickUp Extender on/off
  - **[** - Decrease pickup range
  - **]** - Increase pickup range
- **ModMenu integration** - Easy in-game configuration interface
- **Real-time feedback** - Chat messages confirm your changes
- **HUD status display** - Visual indicator of current status (temporarily disabled in 1.0.1)
- **Configuration system** - Persistent settings with Cloth Config
- **Enhanced tooltips** - Clear explanations of settings and vanilla comparisons

### Technical
- **Fabric mod loader** - Built for Minecraft 1.21.5 with Fabric
- **Mixin system** - Client-side modifications for pickup range and key handling
- **Auto-config** - Automatic configuration management with JSON serialization
- **Multi-environment builds** - Support for development, production, and release builds

---

## Version Information

### Build Types
- **Development**: `pickupextender-dev-*.jar` - For testing and development
- **Production**: `pickupextender-production-*.jar` - For distribution and mod platforms
- **Release**: `pickupextender-*.jar` - For official releases

### Dependencies
- **Minecraft**: 1.21.5
- **Fabric Loader**: ≥0.16.14
- **Fabric API**: ≥0.127.0
- **Java**: ≥21
- **ModMenu**: Optional (for in-game configuration)

---

## Release Notes Template

### For GitHub Releases

```markdown
## 🎉 PickUp Extender v[VERSION] - [TITLE]

### ✨ What's New
- [Feature 1]
- [Feature 2]

### 🔧 Bug Fixes
- [Fix 1]
- [Fix 2]

### 🏗️ Technical Improvements
- [Improvement 1]
- [Improvement 2]

### 📋 Installation
1. Install Fabric Loader for Minecraft 1.21.5
2. Install Fabric API (required)
3. Download this mod and place in your `mods` folder
4. Optional: Install ModMenu for easy configuration
5. Launch Minecraft and enjoy!

### ⚙️ Configuration
- **In-Game**: Use ModMenu for easy configuration
- **Manual**: Edit `config/pickupextender.json`

### 🎮 Features
- Extended Pickup Range (1-20 blocks, configurable)
- Instant Hotkeys (P, [, ])
- ModMenu Integration
- Real-time Feedback
- Vanilla Compatibility

### 🔧 Technical Details
- Minecraft Version: 1.21.5
- Fabric Loader: ≥0.16.14
- Fabric API: ≥0.127.0
- Java: ≥21

### 📦 Files
- `pickupextender-production-[VERSION]+mc.1.21.5.jar` - Production build
- `pickupextender-production-[VERSION]+mc.1.21.5-sources.jar` - Source code

### 👨‍💻 Author
**Patrick Solberg** - [@patricksolberg](https://github.com/patricksolberg)

### 📄 License
CC0-1.0 License
```

---

## Contributing

When adding new entries to this changelog, please follow the established format and categorize changes appropriately:

- **Added** for new features
- **Changed** for changes in existing functionality
- **Deprecated** for soon-to-be removed features
- **Removed** for now removed features
- **Fixed** for any bug fixes
- **Security** for security vulnerability fixes

## Links

- [GitHub Repository](https://github.com/PatrickSolberg/PickUpExtender-fabric)
- [Issues](https://github.com/PatrickSolberg/PickUpExtender-fabric/issues)
- [Releases](https://github.com/PatrickSolberg/PickUpExtender-fabric/releases) 