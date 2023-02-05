/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: false,
  pageExtensions: ['js', 'jsx', 'ts', 'tsx'],
  images: {
    remotePatterns: [
      {
        protocol: 'https',
        hostname: 'mdbcdn.b-cdn.net',
        port: '',
        pathname: '/img/Photos/new-templates/bootstrap-login-form/draw2.webp',
      },
    ],
  },
}

module.exports = nextConfig
