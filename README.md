# PickUp Extender

A Fabric mod for Minecraft that extends the pickup range for items in the world with configurable distance and convenient hotkeys.

## Features

- **Extended Pickup Range**: Pick up items from a greater distance than vanilla Minecraft
- **Configurable Distance**: Adjust the pickup range from 1 to 20 blocks
- **Toggle On/Off**: Enable or disable the extended pickup range
- **Hotkeys**: Quick access to toggle and adjust settings in-game
- **ModMenu Integration**: Easy configuration through ModMenu interface
- **Enhanced Tooltips**: Clear explanations of settings and vanilla comparisons
- **In-Game Feedback**: Chat messages confirm your changes

## Configuration

### In-Game Configuration (Recommended)

1. Install ModMenu alongside this mod
2. Open the ModMenu interface in-game
3. Find "PickUp Extender" in the mod list
4. Click the configuration button to open the settings

### Hotkeys

- **P**: Toggle PickUp Extender on/off
- **[**: Decrease pickup range
- **]**: Increase pickup range

You can customize these keybindings in Minecraft's Controls menu under "PickUp Extender".

### Manual Configuration

You can also edit the configuration file directly:
- Windows: `%APPDATA%/.minecraft/config/pickupextender.json`
- macOS: `~/Library/Application Support/minecraft/config/pickupextender.json`
- Linux: `~/.minecraft/config/pickupextender.json`

### Settings

- **pickupRange**: The maximum distance (in blocks) from which you can pick up items (1-20 blocks, default: 4)
  - Vanilla Minecraft uses 1 block range
  - Higher values allow picking up items from further away
- **enabled**: Toggle the extended pickup range on/off (default: true)
  - When disabled, uses vanilla Minecraft pickup range

### Example Configuration

```json
{
  "pickupRange": 6,
  "enabled": true
}
```

## Dependencies

- **Fabric Loader** (>=0.16.14)
- **Fabric API** (>=0.127.0)
- **Minecraft** (1.21.5)
- **Java** (>=21)

### Optional Dependencies

- **ModMenu**: For in-game configuration interface (highly recommended)

## Installation

1. Install Fabric Loader for Minecraft 1.21.5
2. Download and install Fabric API
3. Download this mod and place it in your `mods` folder
4. (Recommended) Install ModMenu for easy configuration
5. Launch Minecraft and use the hotkeys or ModMenu to configure

## Usage

### Quick Start
1. Launch Minecraft with the mod installed
2. Press **P** to toggle the mod on/off
3. Use **[** and **]** to adjust the pickup range
4. Watch for chat messages confirming your changes

### Advanced Configuration
1. Open ModMenu in-game
2. Find "PickUp Extender" and click the config button
3. Adjust settings with helpful tooltips
4. Click "Done" to save changes

## Building from Source

This project uses semantic versioning with automatic versioning for different build types. See [VERSIONING.md](VERSIONING.md) for detailed information.

### Quick Build
```bash
# Build development version (default)
./gradlew buildDev

# Build production version
./gradlew buildProduction

# Build release version
./gradlew buildRelease
```

### Version Management
```bash
# Show current version info
./gradlew versionInfo

# Increment versions
./gradlew incrementPatch    # 1.0.0 → 1.0.1
./gradlew incrementMinor    # 1.0.0 → 1.1.0
./gradlew incrementMajor    # 1.0.0 → 2.0.0

# Set prerelease versions
./gradlew setPrerelease -Pprerelease=beta.1
./gradlew clearPrerelease
```

### Build Types
- **Development**: `pickupextender-dev-*.jar` - For testing and development
- **Production**: `pickupextender-production-*.jar` - For distribution and mod platforms
- **Release**: `pickupextender-*.jar` - For official releases

Find the built JAR files in `build/libs/`.

## License

This project is licensed under the CC0-1.0 License - see the [LICENSE](LICENSE) file for details.

## Author

Patrick Solberg
- GitHub: [patricksolberg](https://github.com/patricksolberg) 